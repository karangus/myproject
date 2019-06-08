node {
    stage('SCM') {
        git 'https://github.com/asquarezone/game-of-life.git'
    }
    
    stage('Build & Package') {
            sh 'mvn clean package'
       
}
  stage('Deploy-to-Dev'){
         def tomcatIp='ip-172-31-88-209.ec2.internal'
         def tomcatUsr='tomcat'
         def stopTomcat = "${tomcat}@${ip-172-31-88-209.ec2.internal} /apache-tomcat-9.0.20/bin/shutdown.sh"
	  def startTomcat = "${tomcat}@${ip-172-31-88-209.ec2.internal} /apache-tomcat-9.0.20/startup.sh"
         def webApps = "/apache-tomcat-9.0.20/webapps/"
         try{
			 // stop tomcat server
				sh "ssh -o strictHostKeyChecking=no  ${stopTomcat}"
		 }catch(e){
		 
		 }
   }
   
    stage('Results'){
        archive 'gameoflife-web/target/gameoflife.war'
        junit 'gameoflife-web/target/surefire-reports/*.xml'
    }
}
