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
	
	public static String EMPLOYEES_BY_SUPERVISOR = "{call sp_empleado_supervisor(?)}";
	public static String EMPLOYEES_BY_DEPARTMENT = "{call sp_empleado_Departamento(?)}";
	public static String EMPLOYEES_ABSENCE = "{call sp_ausencias_Empleado(?, ?)}";
	public static String EMPLOYEES_LATES = "{call sp_tardia_Empleado(?, ?, ?)}";
	public static String PAYMEND_EMPLOYEE_PERIOD = "{call sp_monto(?, ?, ?)}";
	
	public static String ENTRY_HOUR = "0000-00-00 08:00:00";
	
	public static String EMPLOYEES_WITHOUT_EXIT_TIME = "{call sp_empleados_sin_marca_salida(?, ?)}";
	public static String EMPLOYEES_DISSMISED = "{call sp_empleados_dados_de_baja(?, ?)}";
	
	public static String ENTRY_MARK = "{call sp_marcar_entrada(?, ?)}";
	public static String EXIT_MARK = "{call sp_marcar_salida(?, ?)}";
	
	public static String LOAD_CALENDAR_BY_EMPLOYEE_TYPE = "{call sp_generar_calendario_tipo_empleado(?, ?, ?, ?, ?, ?)}";
        
        public static String GENERAR_PLANILLA = "{call sp_generar_planilla(?, ?)}";
        
        public static String NUEVA_PLANILLA = "{call sp_nueva_planilla(?, ?)}";
        public static String APROBAR_PLANILLA = "{call sp_aprovar_planilla(?, ?)}";
        public static String INGRESAR_CONTENIDO_PLANILLA = "{call sp_ingresar_contenido_planilla(?, ?, ?, ?, ?, ?)}";
}
