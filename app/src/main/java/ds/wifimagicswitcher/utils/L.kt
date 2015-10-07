package ds.wifimagicswitcher.utils

import android.text.TextUtils
import ds.wifimagicswitcher.BuildConfig


public object L {
	
	public val DEBUG: Boolean = BuildConfig.DEBUG
	private val POSFIX_STRING = ")"
	private val PREFIX_STRING = "# ("
	private val PREFIX_MAIN_STRING = "# "
	
	
	public fun v(msg: String) {
		if (DEBUG)
			android.util.Log.v(getLocation(), msg)
	}
	
	
	public fun d(msg: String) {
		if (DEBUG)
			android.util.Log.d(getLocation(), msg)
	}
	
	
	public fun i(msg: String) {
		if (DEBUG)
			android.util.Log.i(getLocation(), msg)
	}
	
	
	public fun w(msg: String) {
		if (DEBUG)
			android.util.Log.w(getLocation(), msg)
	}
	
	
	public fun e(msg: String) {
		if (DEBUG)
			android.util.Log.e(getLocation(), msg)
	}
	
	
	// ==========================================================
	
	
	public fun v(msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.v(getLocation(), msg, e)
	}
	
	
	public fun d(msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.d(getLocation(), msg, e)
	}
	
	
	public fun i(msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.i(getLocation(), msg, e)
	}
	
	
	public fun w(msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.w(getLocation(), msg, e)
	}
	
	
	public fun e(msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.e(getLocation(), msg, e)
	}
	
	
	// ==========================================================
	
	
	public fun v(e: Exception) {
		if (DEBUG)
			android.util.Log.v(getLocation(), "", e)
	}
	
	
	public fun d(e: Exception) {
		if (DEBUG)
			android.util.Log.d(getLocation(), "", e)
	}
	
	
	public fun i(e: Exception) {
		if (DEBUG)
			android.util.Log.i(getLocation(), "", e)
	}
	
	
	public fun w(e: Exception) {
		if (DEBUG)
			android.util.Log.w(getLocation(), "", e)
	}
	
	
	public fun e(e: Exception) {
		if (DEBUG)
			android.util.Log.e(getLocation(), "", e)
	}
	
	
	// ==========================================================
	
	
	/*public static void v(Object obj, String msg) {
		if (DEBUG)
			android.util.Log.v(PREFIX_STRING + obj.getClass().getSimpleName() + POSFIX_STRING + getLocation(), msg);
	}


	public static void d(Object obj, String msg) {
		if (DEBUG)
			android.util.Log.d(PREFIX_STRING + obj.getClass().getSimpleName() + POSFIX_STRING + getLocation(), msg);
	}


	public static void i(Object obj, String msg) {
		if (DEBUG)
			android.util.Log.i(PREFIX_STRING + obj.getClass().getSimpleName() + POSFIX_STRING + getLocation(), msg);
	}


	public static void w(Object obj, String msg) {
		if (DEBUG)
			android.util.Log.w(PREFIX_STRING + obj.getClass().getSimpleName() + POSFIX_STRING + getLocation(), msg);
	}


	public static void e(Object obj, String msg) {
		if (DEBUG)
			android.util.Log.e(PREFIX_STRING + obj.getClass().getSimpleName() + POSFIX_STRING + getLocation(), msg);
	}*/
	
	
	// ==========================================================
	
	
	public fun v(obj: Any, msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.v(PREFIX_STRING + obj.javaClass.simpleName + POSFIX_STRING + getLocation(), msg, e)
	}
	
	
	public fun d(obj: Any, msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.d(PREFIX_STRING + obj.javaClass.simpleName + POSFIX_STRING + getLocation(), msg, e)
	}
	
	
	public fun i(obj: Any, msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.i(PREFIX_STRING + obj.javaClass.simpleName + POSFIX_STRING + getLocation(), msg, e)
	}
	
	
	public fun w(obj: Any, msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.w(PREFIX_STRING + obj.javaClass.simpleName + POSFIX_STRING + getLocation(), msg, e)
	}
	
	
	public fun e(obj: Any, msg: String, e: Exception) {
		if (DEBUG)
			android.util.Log.e(PREFIX_STRING + obj.javaClass.simpleName + POSFIX_STRING + getLocation(), msg, e)
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public fun v(msg: String, vararg formatArgs: Any) {
		if (DEBUG)
			android.util.Log.v(getLocation(), msg.format(*formatArgs))
	}
	
	public fun d(msg: String, vararg formatArgs: Any) {
		if (DEBUG)
			android.util.Log.d(getLocation(), msg.format(*formatArgs))
	}
	
	public fun w(msg: String, vararg formatArgs: Any) {
		if (DEBUG)
			android.util.Log.w(getLocation(), msg.format(*formatArgs))
	}
	
	public fun i(msg: String, vararg formatArgs: Any) {
		if (DEBUG)
			android.util.Log.i(getLocation(), msg.format(*formatArgs))
	}
	
	public fun e(msg: String, vararg formatArgs: Any) {
		if (DEBUG)
			android.util.Log.e(getLocation(), msg.format(*formatArgs))
	}
	
	
	private fun getLocation(): String {
		val className = L::class.java.name
		val traces = Thread.currentThread().stackTrace
		var found = false
		for (i in traces.indices) {
			val trace = traces[i]
			
			try {
				if (found) {
					if (!trace.className.startsWith(className)) {
						val clazz = Class.forName(trace.className)
						return PREFIX_MAIN_STRING + getClassName(clazz) + ":" + trace.methodName + ":" + trace.lineNumber
					}
				} else if (trace.className.startsWith(className)) {
					found = true
					continue
				}
			} catch (e: ClassNotFoundException) {
			}
			
		}
		return "[]: "
	}
	
	
	private fun getClassName(clazz: Class<*>?): String {
		if (clazz != null) {
			if (!TextUtils.isEmpty(clazz.simpleName)) {
				return clazz.simpleName
			}
			
			return getClassName(clazz.enclosingClass)
		}
		
		return ""
	}
}