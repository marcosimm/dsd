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
        }
        require_once 'view/footer.php';
    }
}