package util;

public class Utility {
	public static boolean IS_MARCAS_OPEN = false;
	public static String MODIFY_PLANT_CODE = "{call sp_modificar_codigo_planta(?)}";
	
	public static String INSERT_EMPLOYEE = "{call sp_insertar_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	public static String MODIFY_EMPLOYEE = "{call sp_modificar_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	public static String SEARCH_EMPLOYEE = "{call sp_obtener_empleado(?)}";
	public static String DELETE_EMPLOYEE = "{call sp_eliminar_empleado(?)}";
	
	public static String INSERT_EMPLOYEE_TYPE = "{call sp_insertar_tipo_empleado(?, ?, ?)}";
	public static String MODIFY_EMPLOYEE_TYPE = "{call sp_modificar_tipo_empleado(?, ?, ?, ?)}";
	public static String SEARCH_EMPLOYEE_TYPE = "{call sp_obtener_tipo_empleado(?)}";
	public static String DELETE_EMPLOYEE_TYPE = "{call sp_eliminar_tipo_empleado(?)}";
	
	public static String INSERT_FREE_DAY = "{call sp_modificar_codigo_planta(?)}";
	public static String MODIFY_FREE_DAY = "{call sp_modificar_codigo_planta(?)}";
	public static String SEARCH_FREE_DAY = "{call sp_modificar_codigo_planta(?)}";
	public static String DELETE_FREE_DAY = "{call sp_modificar_codigo_planta(?)}";
	
	public static String INSERT_WORKING_DAY = "{call sp_modificar_codigo_planta(?)}";
	public static String MODIFY_WORKING_DAY = "{call sp_modificar_codigo_planta(?)}";
	public static String SEARCH_WORKING_DAY = "{call sp_modificar_codigo_planta(?)}";
	public static String DELETE_WORKING_DAY = "{call sp_modificar_codigo_planta(?)}";
	
	public static String NEXT_EMPLOYEE_CODE = "{call sp_cantidad_empleados(?)}";
	public static String NEXT_EMPLOYEE_TYPE_CODE = "{call sp_cantidad_tipos_empleado(?)}";
	public static String GET_PLANT_NUMBER = "{call sp_numero_planta(?)}";
}
