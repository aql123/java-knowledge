
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5

START "L1_��������" /D %~dp0\L1_�������� mvn clean compile spring-boot:run
TIMEOUT /T 15
START "L2_�ͻ���" /D %~dp0\L2_�ͻ��� mvn clean compile test