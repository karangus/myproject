node {
    stage('SCM') {
        git 'https://github.com/asquarezone/game-of-life.git'
    }
    
    stage('Build & Package') {
            sh 'mvn clean package'
        
    }
  stage('Deploy-to-Dev'){
    sshagent(['tomcat-dev']) {
         def tomcatIp='ec2-35-178-213-169.eu-west-2.compute.amazonaws.com'
         def tomcatUsr='jenkins'
         def stopTomcat = "${jenkins}@${ec2-35-178-213-169.eu-west-2.compute.amazonaws.com} /apache-tomcat-9.0.20/bin/shutdown.sh"
         def startTomcat = "${jenkins}@${ec2-35-178-213-169.eu-west-2.compute.amazonaws.com} /apache-tomcat-9.0.20/startup.sh"
         def webApps = "/apache-tomcat-9.0.20/webapps/"
         try{
			 // stop tomcat server
				sh "ssh -o strictHostKeyChecking=no  ${stopTomcat}"
		 }catch(e){
		 
		 }
         }
   }
   
    stage('Results'){
        archive 'gameoflife-web/target/gameoflife.war'
        junit 'gameoflife-web/target/surefire-reports/*.xml'
    }
}
