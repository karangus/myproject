node {
    stage('SCM') {
        git 'https://github.com/asquarezone/game-of-life.git'
    }
    
    stage('Build & Package') {
            sh 'mvn clean package'
       
}
  stage('Deploy to Tomcat'){
  sshagent(['tomcat-dev']) {
 sh 'scp -o StrictHostKeyChecking=no target/*.war jenkins@ec2-3-86-202-165.compute-1.amazonaws.com:/apache-tomcat-9.0.20/webapps/'
}
  }
   
    stage('Results'){
        archive 'gameoflife-web/target/gameoflife.war'
        junit 'gameoflife-web/target/surefire-reports/*.xml'
    }
}
