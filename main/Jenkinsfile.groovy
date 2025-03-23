pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/yourusername/your-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'g++ -std=c++11 main/hello.cpp -o main/hello_exec'
            }
        }

        stage('Run') {
            steps {
                sh './main/hello_exec'
            }
        }
    }

    post {
        success {
            echo 'Build and execution successful!'
        }
        failure {
            echo 'Build failed. Check logs.'
        }
    }
}
