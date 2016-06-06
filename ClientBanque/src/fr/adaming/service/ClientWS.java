package fr.adaming.service;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class ClientWS {

	public static void main(String[] args) throws ServiceException, RemoteException {
		//Mon main
		//creer un stub
		BanqueWS stub = new BanqueServiceServiceLocator().getBanqueWSPort();

		//Appel methode conversion
		double res = stub.conversionEuroToFranc(600);
		System.out.println("La conversion de 600 euros en francs est : "+res);
		
		//test autres methodes
		Compte cp = stub.getCompte(1L);
		System.out.println("cp : "+cp);
		
		System.out.println("-----------------------");
		
		Compte[] comptes = stub.getComptes();
		System.out.println("Liste de comptes :");
		for(Compte c : comptes) {
			System.out.println("\t"+c);
		}
		

	}

}
