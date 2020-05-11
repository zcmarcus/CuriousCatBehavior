const initializeDataTables = () => {

    $('#postsTable').DataTable( {
        "searching": false,
        "info":     false,
        "pagingType": "full",
        "lengthChange": false,
        "columnDefs": [
            {
                "targets": [ 3 ],
                "className": 'hiddenColumn'
            }
        ],
        "order": [[1, "desc" ]],
        "lengthMenu": [[10], [10]]
    });


    $('#tagsTable').DataTable( {
        "searching": false,
        "ordering": false,
        "info":     false,
        "paging":   false,
        "lengthChange": false,
    });

    // make entire rows clickable
    $('#postsTable tbody').on('click', 'tr', function () {
        let href = $(this).find('a').prop('href');
        if(href) {
            window.location = href;
        }
    });
}