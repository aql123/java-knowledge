
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START /D %~dp0\R1_����ע������ mvn clean spring-boot:run
TIMEOUT /T 10
START /D %~dp0\R2_�����ṩ��A mvn clean spring-boot:run
START /D %~dp0\R2_�����ṩ��B mvn clean spring-boot:run
TIMEOUT /T 20
START /D %~dp0\R3_�������ѷ� mvn clean spring-boot:run