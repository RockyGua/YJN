class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/template/blog"(view:"/blog")
        "/template/dashboard"(view:"/dashboard")
        "/"(view:"/index")
        "/dashboard"(view:"/index")
        "500"(view:'/error')
	}
}
