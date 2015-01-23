<?php
require_once 'model/login.entidad.php';
require_once 'model/login.model.php';

class LoginController{
    
    private $model;
    
    public function __CONSTRUCT(){
        $this->model = new LoginModel();
    }

    public function Index(){
        require_once 'view/header.php';
        if(isset($_REQUEST['btnIngresar'])){
            $acc = new Login();
            $resultado = $this->model->Obtener($_REQUEST['txtCorreo'], $_REQUEST['txtClave']);

            if($resultado==true){
                require_once 'view/consulta/consulta.php';
            }else{
                require_once 'view/web/web.php';
            }
        }else{
            require_once 'view/login/login.php';
            if(isset($_REQUEST['msg'])){
                require_once 'view/mensajes.php';
            }
        }
        require_once 'view/footer.php';
    }

    public function nuevo(){
        require_once 'view/header.php';
        require_once 'view/login/login-nuevo.php';
        require_once 'view/footer.php';
    }

    public function registrar(){
        $acc = new Login();
        
        $acc->__SET('nom_usuario',          $_REQUEST['txtNombre']);
        $acc->__SET('nom_correo',        $_REQUEST['txtCorreo']);
        $acc->__SET('nom_clave',            $_REQUEST['txtClave']);
        $acc->__SET('nom_empresa', $_REQUEST['txtEmpresa']);
        $acc->__SET('nom_estado', 'A');

        $this->model->registrar($acc);
        header('Location: index.php?c=login&msg=ok');        
    }

    public function recupera(){
        require_once 'view/header.php';
        require_once 'view/login/login-recupera.php';
        if(isset($_REQUEST['msg'])){
            require_once 'view/mensajes.php';
        }
        require_once 'view/footer.php';
    }

    public function enviacorreo(){
        $codigo= time();
        require_once '_lib/class.phpmailer.php';
        $mail = new PHPMailer();
        $mail->From = "recupera@dsd.com.pe";
        $mail->FromName = "Administrador del Sistema";
        $mail->Subject = "Recuperaci&oacute;n de clave";
        $mail->AddAddress($_REQUEST['txtCorreoRecupera']);
        $body = "Su codigo de activaci&oacute;n es: ".$codigo;
        $mail->Body = $body;
        $mail->Send();
        $this->model->recupera($_REQUEST['txtCorreoRecupera'], $codigo);
        if ($mail)
        {
            header('Location: ?c=login&a=recuperafin&msg=cod');
        }
    }

    public function recuperafin(){
       require_once 'view/header.php';
       require_once 'view/login/login-recuperafin.php';
        if(isset($_REQUEST['msg'])){
            require_once 'view/mensajes.php';
        }
        require_once 'view/footer.php';
    }

    public function recuperado(){
        $recuperado = $this->model->recuperado($_REQUEST['txtCodigoFin'], $_REQUEST['txtClaveFin'], $_REQUEST['txtCorreoFin']);
        if($recuperado==true){
            header('Location: ?c=login&msg=ok&s='.$_SESSION['correorecupera']);
        }else{
            header('Location: ?c=login&a=recuperafin&msg=errrec');
        }
    }
}