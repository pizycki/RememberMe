export class App {

    configureRouter(config, router) {
        this.router = router; 
 
        config.title = "Remember me!";
        config.map([
            { route: "", name: 'home', moduleId: "films/list", title:"Films", nav:true},            
            { route: "details/:id", name:"details", moduleId: "films/details" },
            { route: "edit/:id", name:"edit", moduleId: "films/edit" },
            { route: "create", name:"create", moduleId:"films/edit" }
        ]);
    }
}