
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "R1_����ע������" /D %~dp0\R1_����ע������ mvn clean spring-boot:run
TIMEOUT /T 10
START "R2_�����ṩ��A" /D %~dp0\R2_�����ṩ��A mvn clean spring-boot:run
START "R2_�����ṩ��B" /D %~dp0\R2_�����ṩ��B mvn clean spring-boot:run
TIMEOUT /T 20
START "R3_�������ѷ�" /D %~dp0\R3_�������ѷ� mvn clean test