
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "K3_�ͻ���" /D %~dp0\K3_�ͻ��� mvn clean compile spring-boot:run