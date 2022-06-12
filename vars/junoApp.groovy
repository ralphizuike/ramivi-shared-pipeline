def call(String repoUrl){
  pipeline{
     	agent any
     	stages{
     		stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
     		stage('parallel-job'){
     			parallel{
     				stage('sub-job1'){
     					steps{
     						echo 'action1'
     					}
     				}
     				stage('sub-job2'){
     					steps{
     						sh 'systemctl status jenkins'
     					}
     				}
     				stage('sub-job3'){
     					steps{
     						sh 'ps -ef'

     					}
     				}
     				stage('sub-job4'){
     					steps{
     						echo 'Dr Eng Ike'
     					}
     					
     				}
     			}

     		}
     		stage('codebuild'){
     			steps{
     				sh 'cat /etc/passwd'
     			}
     		}
             stage('parallel-job2'){
                 parallel{
                     stage('check'){
                         steps{
                             sh 'ps -ef'
                         }
                     }
                     stage('calander'){
                         steps{
                             sh 'cal 2025'
                         }
                     }
                     stage('lscpu'){
                         steps{
                             sh 'lscpu'
                         }
                     }
                      stage('jenkinsID'){
                           steps{
                             sh 'ls'
                            }
                 }
             }
     	}
     }
}
