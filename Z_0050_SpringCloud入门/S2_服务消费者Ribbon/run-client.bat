
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "R3_�������ѷ�" /D %~dp0\R3_�������ѷ� mvn clean compile test