
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "H1_����ע������" /D %~dp0\H1_����ע������ mvn clean compile spring-boot:run
TIMEOUT /T 15
START "H2_�����ṩ��" /D %~dp0\H2_�����ṩ�� mvn clean compile spring-boot:run