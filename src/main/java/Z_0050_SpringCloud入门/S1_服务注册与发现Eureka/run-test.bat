
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START /D %~dp0\E1_����ע������ mvn clean spring-boot:run
TIMEOUT /T 10
START /D %~dp0\E2_������뷽 mvn clean spring-boot:run