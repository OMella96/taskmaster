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
        withSonarQubeEnv('SonarQube') {
          sh 'mvn sonar:sonar'
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
