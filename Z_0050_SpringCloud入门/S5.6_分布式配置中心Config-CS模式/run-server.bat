
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "L1_��������" /D %~dp0\L1_�������� mvn clean compile spring-boot:run