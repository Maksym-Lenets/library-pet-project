<html>
<head>
    <title>Title</title>
    <%@include file="../parts/headTag.jsp" %>
    <script type='text/javascript'>
        function addFields(){
            // Generate a dynamic number of inputs
            var number = document.getElementById("member").value;
            // Get the element where the inputs will be added to
            var container = document.getElementById("container");
            // Remove every children it had before
            while (container.hasChildNodes()) {
                container.removeChild(container.lastChild);
            }
            for (i=0;i<number;i++){
                // Append a node with a random text
                container.appendChild(document.createTextNode("Member " + (i+1)));
                // Create an <input> element, set its type and name attributes
                var input = document.createElement("input");
                input.type = "text";
                input.name = "member" + i;
                container.appendChild(input);
                // Append a line break
                container.appendChild(document.createElement("br"));
            }
        }
    </script>
</head>
<body>
<input type="text" id="member" name="member" value="">Number of members: (max. 10)<br />
<a href="#" id="filldetails" onclick="addFields()">Fill Details</a>
<div id="container"/>

<div style="width: 70%; margin: 30px auto">

    <form onsubmit="handleCreateProduct(event)">
        <div class="mb_3">
            <label for="name" class="form-label">Product Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb_3">
            <label for="description" class="form-label">Description</label>
            <textarea id="description" class="form-control" name="description" rows="3"></textarea>
        </div>
        <div class="mb_3">
            <label for="price" class="form-label">Price in $</label>
            <input type="number" id="price" class="form-control" min="1" name="price">
        </div>

        <div class="mb_3">
            <label for="image" class="form-label">Image</label>
            <input type="file" id="image" class="form-control" min="1" name="image">
        </div>

        <input type="submit" class="btn_btn-primary">
    </form>
</div>


</body>
</html>