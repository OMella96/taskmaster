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
        withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
          sh 'mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN -Dsonar.host.url=http://host.docker.internal:9000'
        }
      }
    }

    // ✅ Nuevo stage para OWASP Dependency-Check
    stage('Dependency Check') {
      steps {
        sh '/opt/dependency-check/bin/dependency-check.sh --project "MiProyecto" --scan . --format HTML --out reports/ --data /var/dependency-check-data'
      }
    }

    stage('Ejecutar con perfil') {
      steps {
        sh "mvn exec:java -P${params.ENTORNO} -Denv.name=${params.ENTORNO}"
      }
    }
  }
}
