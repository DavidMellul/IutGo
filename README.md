# IutGo
Projet universitaire de création d'un réseau social avec géololocalisation et gestion des points d'intérêt.

# Aspects techniques

- Le logiciel se connecte à une base données contenant l'id des membres créés, et ensuite va chercher ces membres sur un serveur FTP.
- Sur le serveur et sur le machine locale, les membres sont sérialisés avec l'extension ".dat" dans le dossier AppData sur Windows, et son équivalent sur Mac. (Le logiciel s'en charge automatiquement)
- La géolocalisation se fait grâce à l'API MaxMind v1, elle est assez imprécise mais largement suffisante pour un projet universitaire.
- Les éléments graphiques, les effets stylistiques de l'interface, et les marqueurs sur la map affichée ont été dessinés à l'aide d'outils d'édition d'images.
- Nous avons mis en place 5 design-patterns : Observer-Observable / Modèle-Vue-Contrôleur (x2) / Factory / Expert / Singleton.
- La carte est affichée grâce à l'API OpenStreetMap.


# Prolongements possibles de ce projet

- Fournir un exécutable compatible Windows et Mac (en se servant d'un build.xml et de l'outil Ant pour déployer sur Mac).
- Faire réellement usage de la base de données en y stockant toutes les informations, plutôt que de se servir d'un serveur FTP.
- Implémenter un système d'envoi de mail automatique (pour récupérer son mot de passe, pour voir des news, ou autre).
- Gamifier le logiciel pour pousser l'utilisateur à rester dessus en ludifiant son expérience.
- Imaginer un portage vers appareils mobiles ?


# Refactorisation et améliorations possibles

- Utiliser l'API GoogleMap, autant pour l'affichage de la carte que pour tout ce qui a un lien avec la géolocalisation.
- Créer nos propres composants Java afin d'éviter toutes les duplications de codes pour la gestion de l'apparence (Hover/Clic/etc)
- Gérer les accès concurrents aux fichiers sur le serveur FTP.
- Faire en sorte que l'interface puisse fonctionner en plein écran grâce à des Layouts.
- Implémenter toutes les fonctionnalités codées dans l'interface.
- Proposer un système plus sécurisé (au niveau de la gestion du "Mot de passe oublié" notamment).



