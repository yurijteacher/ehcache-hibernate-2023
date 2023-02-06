<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h2>Save</h2>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>description</th>
    </tr>
    </thead>
    <tbody>

    <form action="/save" method="post">
        <tr>
            <td>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" placeholder="name">
            </td>
            <td>
                <label for="description">Description</label>
                <input type="text" id="description" name="description" placeholder="description">
            </td>
        </tr>
        <tr>
            <td>

            </td>
            <td>
                <input type="submit" value="add">
            </td>
        </tr>
    </form>

    </tbody>

</table>

<h2>List</h2>
<ul>
    <#if categories??>
        <#list categories as category>
            <li>
                <a href="/${category.id}">${category.name}</a>
            </li>
        </#list>
    </#if>
</ul>

<h2>Update/Delete</h2>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>description</th>
    </tr>
    </thead>
    <tbody>
    <#if categories??>
        <#list categories as category>
            <form action="/update" method="post">
                <tr>
                    <td>
                        <input type="hidden" name="id" value="${category.id}">
                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" value="${category.name}">
                    </td>
                    <td>
                        <label for="description">Description</label>
                        <input type="text" id="description" name="description" value="${category.description}">
                    </td>
                    <td>
                        <button type="submit">update</button>
                    </td>

            </form>
            <form action="/delete" method="post">
                <input type="hidden" name="id" value="${category.id}">
                <td>
                    <input type="submit" value="delete">
                </td>
            </form>

            </tr>
        </#list>
    </#if>
    </tbody>
</table>


</body>
</html>