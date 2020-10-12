package fr.wither.utils;

import java.io.File;
import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

/**
 * 
 * La seule et unique classe de SystemInformations, elle contient les m�thodes pour obtenir les information syst�me.
 * @author Wither
 * @version 0.2.0
 * 
 */

public class SystemInformations {
	

	public SystemInformations() {
		
	}
	
	/**
	 * Choix du facteur entre un octet et un Go (Gio pour etre exact dans ce cas-ci) : {@value}
	 */
	public static final long BYTES_TO_GO = 1073741824 ;
	
	/**
	 * M�thode d'obtention de la RAM totale de l'ordinateur
	 * @since 0.0.1
	 * @return
	 * le maximum de m�moire vive(RAM) de l'ordinateur. /!\ peut �tre sous-estim�e
	 */
	public static final long getSystemRAM() {
		return ((OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize() / BYTES_TO_GO;
	}
	
	/**
	 * M�thode d'obtention du type d'architecture java
	 * @since 0.0.1
	 * @return
	 * 	Unknown, 32 ou 64 suivant l'architecture java (32 bits, 64 bits, Inconnue/Indeterminable)
	 */
	public static final String getJavaBits() {
		return System.getProperty("sun.arch.data.model");
	}
	
	/**
	 * M�thode d'obtention de l'espace disque
	 * @since 0.0.1
	 * @return
	 * l'espace disque total
	 */
	public static final long getDiskSize() {
		return new File("/").getTotalSpace() / BYTES_TO_GO;
	}
	
	/**
	 * La premi�re m�thode pour la version de java
	 * @since 0.0.1
	 * @return
	 * la version java sous la forme X.X
	 */
	public static final String getJavaVersion() {
		return System.getProperty("java.specification.version");
	}
	
	/**
	 * La seconde m�thode pour la version de java
	 * @since 0.0.1
	 * @return
	 * la version de java sous la forme X.X.X_XXX
	 */
	public static final String getExactJavaVersion() {
		return System.getProperty("java.version");
	}
	
	/**
	 * M�thode permettant de d�terminer si le systeme est un windows ou non
	 * @since 0.2.0
	 * @return
	 * Une valeur bool�enne vraie si le programme est lanc� sur windows, faux sinon.
	 */
	public static final boolean isWindows() {
		return System.getProperty("sun.desktop").toLowerCase().contains("windows");
	}
	/**
	 * M�thode retournant le nom du syst�me d'exploitation
	 * @since 0.2.0
	 * @return
	 * le nom de l'OS
	 */
	public static final String getOSName() {
		return System.getProperty("os.name");
	}
	/**
	 * M�thode retournant le nom de l'utilisateur du programme.
	 * @since 0.2.0
	 * @return
	 * Le nom d'utilisateur de la personne qui execute le programme
	 */
	public static final String getUserName() {
		return System.getProperty("user.name");
	}
}
