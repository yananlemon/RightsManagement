package site.ilemon.rightsmanagement.security;

import org.apache.catalina.User;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public Object resolveArgument(MethodParameter param,
			ModelAndViewContainer mv, NativeWebRequest webRequest,
			WebDataBinderFactory arg3) throws Exception {
		Authentication auth = (Authentication) webRequest.getUserPrincipal();
	    return auth != null && auth.getPrincipal() instanceof User ? auth.getPrincipal() : null;
	}

	@Override
	public boolean supportsParameter(MethodParameter param) {
		return User.class.isAssignableFrom(param.getClass());
	}

}
