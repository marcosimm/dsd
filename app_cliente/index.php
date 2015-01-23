<?php
// Todo esta lógica hara el papel de un FrontController
if(!isset($_REQUEST['c'])){
	require_once 'controller/web.controller.php';
    $controller = new WebController();
    $controller->Index();
} else {
    require_once 'controller/'.$_REQUEST['c'].'.controller.php';
    // Obtenemos el controlador que queremos cargar
    $controller = $_REQUEST['c'] . 'Controller';
    $accion     = isset($_REQUEST['a']) ? $_REQUEST['a'] : 'Index';
    
    
    // Instanciamos el controlador
    $controller = new $controller();
    
    // Llama la accion
    call_user_func( array( $controller, $accion ) );
}


