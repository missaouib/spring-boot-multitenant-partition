tenants = [
    {
        'name': 'tenant1',
        'server_name': 'tenant1.designre.io',
        'root': '/var/www/tenant1',
        # Add other tenant-specific configurations here
    },
    {
        'name': 'tenant2',
        'server_name': 'tenant2.designre.io',
        'root': '/var/www/tenant2',
        # Add other tenant-specific configurations here
    },
    # Add more tenants as needed
]

nginx_config_template = """
server {{
    server_name {server_name};
    root {root};
    access_log /var/log/nginx/{tenant}-access.log;
    error_log /var/log/nginx/{tenant}-error.log;

    # Add other location directives here
}}
"""

nginx_config_content = ""

for tenant in tenants:
    nginx_config_content += nginx_config_template.format(
        server_name=tenant['server_name'],
        root=tenant['root'],
        tenant=tenant['name']
    )

# Write the generated NGINX configuration content to a file
with open('/etc/nginx/conf.d/multi-tenant.conf', 'w') as nginx_config_file:
    nginx_config_file.write(nginx_config_content)

# Reload NGINX to apply the new configuration
# Make sure to handle errors appropriately
# e.g., check return code, handle exceptions
os.system('nginx -s reload')