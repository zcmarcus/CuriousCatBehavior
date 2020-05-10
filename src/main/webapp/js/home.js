const initializeDataTables = () => {

    $('#allPostsTable').DataTable({
        "columnDefs": [
            {
                "targets": [ 3 ],
                "className": 'hiddenColumn'
            }
        ],
        "order": [[1, "desc" ]],
        "lengthMenu": [[25, 50, -1], [25, 50, "All"]]
    });
    $('#allTagsTable').DataTable({
        "lengthMenu": [[25, 50, -1], [25, 50, "All"]]
    });

    // make entire rows clickable
    $('#allPostsTable tbody').on('click', 'tr', function () {
        let href = $(this).find('a').prop('href');
        if(href) {
            window.location = href;
        }
    });
}