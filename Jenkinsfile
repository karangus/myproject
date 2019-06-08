node {
    stage('SCM') {
        git 'https://github.com/asquarezone/game-of-life.git'
    }
    
    stage('Build & Package') {
            sh 'mvn clean package'
        
    }
  stage('Deploy-to-Dev'){
    // renaming warfile
    sh 'mv target/myweb*.war target/myweb.war'
   
    sshagent(['tomcat-dev']) {
         def tomcatIp='172.31.19.12'
         def tomcatUsr='tomcat'
         def stopTomcat = "${tomcat}@${172.31.19.12} /opt/tomcat9/bin/shutdown.sh"
         def startTomcat = "${tomcat}@${172.31.19.12} /opt/tomcat9/bin/startup.sh"
         def webApps = "/opt/tomcat9/webapps/"
         try{
			 // stop tomcat server
				sh "ssh -o strictHostKeyChecking=no  ${stopTomcat}"
		 }catch(e){
		 
		 }
    
    
    
    
    stage('Results'){
        archive 'gameoflife-web/target/gameoflife.war'
        junit 'gameoflife-web/target/surefire-reports/*.xml'
    }
}
