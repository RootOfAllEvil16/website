package com.project.eva.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Класс наследующий AbstractSecurityWebApplicationInitializer.
 * Класс нужен для того, чтобы удостовериться, что настройки безопасности включены в основной
 * контекст приложения (их увидел и втянул в себя Root Application Context).
 * Для этого нужен этот класс. Нам нужно настроить все так чтобы определенный
 * URL проходил через уровень безопасности.
 *

 * @version 1.2
 * @see SecurityConfig
 * @see RootConfig
 * @see WebConfig
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}