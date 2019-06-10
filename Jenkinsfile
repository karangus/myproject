node {
    stage('SCM') {
        git 'https://github.com/asquarezone/game-of-life.git'
    }
    
    stage('Build & Package') {
            sh 'mvn clean package'
      
}
    
    
stage('Deploy-to-Dev'){
    // renaming warfile
    sh 'mv  gameoflife-web/target/gameoflife.war gameoflife-web/target/myweb.war'
   
    sshagent(['tomcat-dev']) {
         def tomcatIp='ip-172-31-88-209.ec2.internal'
         def tomcatUsr='ubuntu'
         def stopTomcat = "${ubuntu}@${ip-172-31-88-209.ec2.internal} /home/jenkins/apache-tomcat-9.0.20 /bin/shutdown.sh"
         def startTomcat = "${ubuntu}@${ip-172-31-88-209.ec2.internal} /home/jenkins/apache-tomcat-9.0.20 /bin/startup.sh"
         def webApps = "/home/jenkins/apache-tomcat-9.0.20 /webapps/"
         try{
			 // stop tomcat server
				sh "ssh -o strictHostKeyChecking=no  ${stopTomcat}"
		 }catch(e){
		 
		 }
         try{
			// remove old war on tomcat
			sh "ssh ubuntu@${ip-172-31-88-209.ec2.internal} rm /home/jenkins/apache-tomcat-9.0.20/webapp/gameoflife.war*"
		 }catch(e){
		 
		 }
         // copy new war to tomcat
         sh "scp gameoflife-web/target/myweb.war ${ubuntu}@${ip-172-31-88-209.ec2.internal}:${webapps}"
         // start tomcat
         sh "ssh ${startTomcat}"
    }
    
  }
   
    stage('Results'){
        archive 'gameoflife-web/target/gameoflife.war'
        junit 'gameoflife-web/target/surefire-reports/*.xml'
    }
}
