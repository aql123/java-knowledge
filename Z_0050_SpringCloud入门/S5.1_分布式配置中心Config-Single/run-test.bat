
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "C1_��������" /D %~dp0\C1_�������� mvn clean compile test