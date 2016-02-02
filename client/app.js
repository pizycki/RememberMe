export class App {

    configureRouter(config, router) {
        this.router = router; 
 
        config.title = "Films";
        config.map([
            { route: "", name: 'home', moduleId: "films/list", title:"List", nav:true},
            { route: "top", name: "top", moduleId: "films/list", title:"Top 10", nav:true},
            { route: "about", moduleId: "about/about", title: "About", nav:true },            
            { route: "details/:id", name:"details", moduleId: "films/details" },
            { route: "edit/:id", name:"edit", moduleId: "films/edit" },
            { route: "create", name:"create", moduleId:"films/edit" }
        ]);
    }
}