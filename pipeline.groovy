pipeline{
    agent any 
    stages {
        stage('pull'){
            steps{
                git branch: 'main', url: 'https://github.com/mayurmwagh/Newfrontend.git'
            }
        }
        stage('build'){
            steps{
                sh '''
                    npm install
                    ng build 
                '''
            }
        }
        stage('deploy'){
            steps{
                sh '''
                    aws s3 cp --recursive dist/angular-frontend s3://cbz-frontend-project-bux123-king/
                '''
            }
        }
    }
}