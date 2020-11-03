pipeline{
  agent any
  tools {
        maven 'maven'
        bat ' mvn -f pom.xml clean install'
    }
    stages {
      stage('Compile Stage'){
        steps{
          withMaven(maven : 'maven'){
            sh 'mvn clean compile'
          }
        }
      }
      
      stage ('Testing Stage'){
        steps{
          withMaven(maven : 'maven'){
            sh 'mvn test'
          }
        }
      }
      
      stage ('Deployment Stage'){
        steps {
          withMaven(maven : 'maven'){
            sh 'mvn deploy'
          }
        }
      }
    }
  }
