<section id="contact-page" class="container">
    <div class="row-fluid">
        <div class="span6">
            <h4>Recuperaci&oacute;n de clave de acceso</h4>
            <div class="status alert alert-success" style="display: none"></div>
            <table>
            <form id="frmUsuarioRecupera" name="frmUsuarioRecupera" method="post" action="?c=login&a=enviacorreo">
                    <tr>
                    	<td>
                    		<label>Correo electr&oacute;nico</label>
                    		<input type="email" name="txtCorreoRecupera" id="txtCorreoRecupera" class="input-block-level" required="required" placeholder="Tu correo electr&oacute;nico">
                    	</td>
                    </tr>
                    <tr>
                    	<td>
                         	<input type="submit" name="btnRecupera" id="btnRecupera" class="btn btn-primary btn-large pull-left" value="Recuperar">
                         </td>
                    <tr>
            </form>
            </table>
        </div>
    </div>
</section>