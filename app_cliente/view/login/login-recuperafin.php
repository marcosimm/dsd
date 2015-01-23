<div class="row-fluid" style="margin-left:7%;">
    <div class="span6">
        <h4>Registro nuevo de usuario</h4>
        <table>
        <form id="frmUsuarioRecupera" name="frmUsuarioRecuperado" method="post" action="?c=login&a=recuperado">
                <tr>
                    <td>
                        <label>Nueva Clave</label>
                        <input type="hidden" name="txtCorreoFin" id="txtCorreoFin" class="input-block-level" required="required" value="<?php ini_set('display_errors',0); session_start(); echo $_SESSION['correorecupera'];?>" >
                        <input type="password" name="txtClaveFin" id="txtClaveFin" class="input-block-level" required="required" placeholder="Tu clave de acceso">
                    <td>
                        <label>Repita Clave</label>
                        <input type="password" name="txtReClaveFin" id="txtReClaveFin" class="input-block-level" required="required" placeholder=" Repite tu clave">
                    </td>
                </tr>                    
                <tr>
                	<td colspan="2">
                        <label>C&oacute;digo de activaci&oacute;n</label>
                     	<input type="text" name="txtCodigoFin" id="txtCodigoFin" class="input-block-level">
                     </td>
                <tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="btnRecuperaFin" id="btnRecuperaFin" class="btn btn-primary btn-large pull-left" value="Recuperar">
                     </td>
                <tr>
        </form>
        </table>
    </div>
</div>