import com.yjn.web.yjnstore.Requestmap
import com.yjn.web.yjnstore.SecRole
import com.yjn.web.yjnstore.SecUser
import com.yjn.web.yjnstore.SecUserSecRole

class BootStrap {

    def init = { servletContext ->
        SecUser admin = new SecUser(username:'admin', password:'secret', enabled:true).save()
        SecUser john = new SecUser(username:'john', password:'secret', enabled:true).save()
        SecUser jane = new SecUser(username:'jane', password:'secret', enabled:true).save()
        SecRole royalty = new SecRole(authority: 'ROLE_ROYALTY').save()
        SecRole common = new SecRole(authority: 'ROLE_COMMON').save()
        SecUserSecRole.create(admin, royalty)
        SecUserSecRole.create(admin, common)
        SecUserSecRole.create(john, common)

        new Requestmap(url: '/screen/authenticatedPage', configAttribute: 'IS_AUTHENTICATED_FULLY').save()
        new Requestmap(url: '/screen/commonPage', configAttribute: 'ROLE_COMMON').save()
        new Requestmap(url: '/screen/royalPage', configAttribute: 'ROLE_ROYALTY').save()
        new Requestmap(url: '/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
    }
    def destroy = {
    }
}
