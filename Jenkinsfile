pipeline {
  agent any

  parameters {
    string(name: 'ENTORNO', defaultValue: 'dev', description: 'Ambiente de ejecución')
  }

  stages {
    stage('Compilar') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

   stage('Análisis SonarQube') {
  steps {
    withCredentials([string(credentialsId: 'e65c9702-18a0-4e23-976c-e99e3cd744d9', variable: 'SONAR_TOKEN')]) {
      sh 'mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN -Dsonar.host.url=http://localhost:9000'
    }
  }
}

    stage('Ejecutar con perfil') {
      steps {
        sh "mvn exec:java -P${params.ENTORNO} -Denv.name=${params.ENTORNO}"
      }
    }
  }
}
