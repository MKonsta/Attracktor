<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>Hello World</h1>

    <ul>
        <#list foodTypes as type>
            <li>${type.id} - ${type.name} - ${type.icon}</li>
        </#list>
    </ul>

</body>
</html>