
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "V1_��������" /D %~dp0\V1_�������� mvn clean compile spring-boot:run