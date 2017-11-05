package util;

public class Utility {
	public static boolean IS_MARCAS_OPEN = false;
	public static String MODIFY_PLANT_CODE = "{call sp_modificar_codigo_planta(?)}";
	
	public static String INSERT_EMPLOYEE = "{call sp_insertar_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	public static String UPDATE_EMPLOYEE = "{call sp_modificar_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	public static String SEARCH_EMPLOYEE = "{call sp_obtener_empleado(?)}";
	public static String DELETE_EMPLOYEE = "{call sp_eliminar_empleado(?)}";
	
	public static String INSERT_EMPLOYEE_TYPE = "{call sp_insertar_tipo_empleado(?, ?, ?)}";
	public static String UPDATE_EMPLOYEE_TYPE = "{call sp_modificar_tipo_empleado(?, ?, ?, ?)}";
	public static String SEARCH_EMPLOYEE_TYPE = "{call sp_obtener_tipo_empleado(?)}";
	public static String DELETE_EMPLOYEE_TYPE = "{call sp_eliminar_tipo_empleado(?)}";
	
	public static String INSERT_HOLIDAY = "{call sp_insertar_feriado(?, ?)}";
	public static String UPDATE_HOLIDAY = "{call sp_modificar_feriado(?, ?)}";
	public static String SEARCH_HOLIDAY = "{call sp_obtener_feriado(?)}";
	public static String DELETE_HOLIDAY = "{call sp_eliminar_feriado(?)}";
	public static String GET_ALL_HOLIDAYS = "{call sp_obtener_feriados()}";
	
	public static String UPDATE_WORKING_DAY = "{call sp_modificar_dia_laborable(?, ?)}";
	public static String SEARCH_WORKING_DAY = "{call sp_obtener_dia_laborable(?)}";
	
	public static String NEXT_EMPLOYEE_CODE = "{call sp_cantidad_empleados(?)}";
	public static String NEXT_EMPLOYEE_TYPE_CODE = "{call sp_cantidad_tipos_empleado(?)}";
	public static String GET_PLANT_NUMBER = "{call sp_numero_planta(?)}";
	public static String LOAD_CALENDAR = "{call sp_generar_calendario()}";
}
