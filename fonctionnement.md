

SAKILA -> DAO input (Ligne SQL -> Classe Java) -> Message(Type de message, Classe Java)

- Les threads
    - Emetteur
        - Menu (dire quelle table on transfert)
          - 
        - La recuperation
        - Emettre un evenement
    - Recepteur
        - Ecouter les evenements
        - Ecrire dans la base (prendre en compte/skip si la table/ligne existe deja)
        - Lors de la fermeteur, Compte-rendu
    - Commande
      - Data
      - Stop
      - (Start)
    - Connexion avec postgres
      - Editer le fichier persistence.xml
      - Modifier le DAO pour choisir le persistence unit