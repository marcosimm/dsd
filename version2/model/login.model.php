<?php
class LoginModel
{
	private $pdo;

	public function __CONSTRUCT()
	{
		try
		{
			$this->pdo = new PDO('mysql:host=localhost;dbname=db_dsd', 'root', '21846168');
			$this->pdo->exec("SET CHARACTER SET utf8");
			$this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);		        
		}
		catch(Exception $e)
		{
			die($e->getMessage());
		}
	}

	public function Obtener($correo, $clave)
	{
		try 
		{
			$stm = $this->pdo
			          ->prepare("SELECT cod_usuario, nom_usuario,nom_correo, nom_empresa, nom_estado FROM tb_usuario WHERE nom_correo = ? AND nom_clave = ?");
		    
			$stm->execute(array($correo, $clave));

			if($stm->rowCount()==0){
				return false;
			}else{
				$r = $stm->fetch(PDO::FETCH_OBJ);
				session_start();
				$_SESSION['codigousuario'] = $r->cod_usuario;
				$_SESSION['nombreusuario'] = $r->nom_usuario;
				$_SESSION['nombrecorreo'] = $r->nom_correo;
				$_SESSION['nombreempresa'] = $r->nom_empresa;
				$_SESSION['nombreestado'] = $r->nom_estado;
				return true;
			}
		} catch (Exception $e) 
		{
			die($e->getMessage());
		}
	}

	public function registrar(Login $data)
	{
		try 
		{
		$sql = "INSERT INTO tb_usuario (nom_usuario, nom_correo, nom_clave, nom_empresa, nom_estado)
		        VALUES (?, ?, ?, ?,?)";

		$this->pdo->prepare($sql)
		     ->execute(
			array(
				$data->__GET('nom_usuario'), 
				$data->__GET('nom_correo'), 
				$data->__GET('nom_clave'),
				$data->__GET('nom_empresa'),
				$data->__GET('nom_estado')
				)
			);
		} catch (Exception $e) 
		{
			die($e->getMessage());
		}
	}

	public function recupera($correo,$codigo)
	{
		$_SESSION['correorecupera'] = $correo;
		try 
		{
		$sql = "INSERT INTO tb_recupera (nom_correo, cod_activacion)
				VALUES (?, ?)";
		$this->pdo->prepare($sql)
		     ->execute(
			array($correo, $codigo)
			);
		} catch (Exception $e) 
		{
			die($e->getMessage());
		}
	}

	public function recuperado($codigo, $clave, $correo){
		try{
			//$this->pdo->beginTransaction();
				//Verificamos el código de ativación.
			$stm = $this->pdo
			          ->prepare("SELECT nom_correo, cod_activacion FROM tb_recupera WHERE cod_activacion = ?");
		    $stm->execute(array($codigo));
			if($stm->rowCount()==0){
				return false;
			}else{

				$sqlActualiza = "UPDATE tb_usuario SET nom_clave = ? WHERE nom_correo = ?";
				$this->pdo->prepare($sqlActualiza)
					->execute(
						array($clave, $correo)
					);

				$sqlElimina = "DELETE FROM tb_recupera WHERE cod_activacion = ?";
				$this->pdo->prepare($sqlElimina)
					->execute(
						array($codigo)
					);

				//session_start();
				//unset($_SESSION['correorecupera']);
				return true;
			}
			//$this->pdo->commit();
		}catch (Exception $e) 
		{
			die($e->getMessage());
		}
	}
}