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
         def tomcatUsr='jenkins'
         def stopTomcat = "${jenkins}@${172.31.19.12} /apache-tomcat-9.0.20/bin/shutdown.sh"
         def startTomcat = "${jenkins}@${172.31.19.12} /apache-tomcat-9.0.20/startup.sh"
         def webApps = "/apache-tomcat-9.0.20/webapps/"
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
