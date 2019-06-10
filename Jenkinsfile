node {
    stage('SCM') {
        git 'https://github.com/asquarezone/game-of-life.git'
    }
    
    stage('Build & Package') {
            sh 'mvn clean package'
       
}
  stage('Deploy to Tomcat'){
  sshagent(['tomcat-dev']) {
 sh 'scp -o StrictHostKeyChecking=no gameoflife-web/target/*.war ubuntu@ip-172-31-88-209.ec2.internal:/home/jenkins/apache-tomcat-9.0.20/webapps/'
}
  }
   
    stage('Results'){
        archive 'gameoflife-web/target/gameoflife.war'
        junit 'gameoflife-web/target/surefire-reports/*.xml'
    }
}
