package fr.adaming.service;

public class BanqueWSProxy implements fr.adaming.service.BanqueWS {
  private String _endpoint = null;
  private fr.adaming.service.BanqueWS banqueWS = null;
  
  public BanqueWSProxy() {
    _initBanqueWSProxy();
  }
  
  public BanqueWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initBanqueWSProxy();
  }
  
  private void _initBanqueWSProxy() {
    try {
      banqueWS = (new fr.adaming.service.BanqueServiceServiceLocator()).getBanqueWSPort();
      if (banqueWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)banqueWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)banqueWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (banqueWS != null)
      ((javax.xml.rpc.Stub)banqueWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.adaming.service.BanqueWS getBanqueWS() {
    if (banqueWS == null)
      _initBanqueWSProxy();
    return banqueWS;
  }
  
  public double conversionEuroToFranc(double montant) throws java.rmi.RemoteException{
    if (banqueWS == null)
      _initBanqueWSProxy();
    return banqueWS.conversionEuroToFranc(montant);
  }
  
  public fr.adaming.service.Compte getCompte(long idCompte) throws java.rmi.RemoteException{
    if (banqueWS == null)
      _initBanqueWSProxy();
    return banqueWS.getCompte(idCompte);
  }
  
  public fr.adaming.service.Compte[] getComptes() throws java.rmi.RemoteException{
    if (banqueWS == null)
      _initBanqueWSProxy();
    return banqueWS.getComptes();
  }
  
  
}