
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "J1_��������A" /D %~dp0\J1_��������A mvn clean compile spring-boot:run
START "J2_��������B" /D %~dp0\J2_��������B mvn clean compile spring-boot:run