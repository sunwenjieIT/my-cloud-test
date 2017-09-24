pipeline {
  agent {
    docker {
      image 'maven:3.3.3'
    }
    
  }
  stages {
    stage('Build') {
      steps {
        sh 'echo "hello world"'
      }
    }
    stage('') {
      steps {
        sh 'mvn --version'
      }
    }
  }
}