const initializeDataTables = () => {

    $('#postsTable').DataTable( {
        "searching": false,
        "info":     false,
        "pagingType": "full",
        "lengthChange": false,
        "order": [[3, "desc" ]],
        "columnDefs": [
            {
                "targets": [ 2 ],
                "orderData" : 3
            },
            {
                "targets": [ 3 ],
                "className" : 'hiddenColumn'
            },
            {
                "targets": [ 5 ],
                "className": 'hiddenColumn'
            }
        ],
        "lengthMenu": [[10], [10]]
    });

    // $('#tagsTable').DataTable( {
    //     "searching": false,
    //     "ordering": false,
    //     "info":     false,
    //     "paging":   false,
    //     "lengthChange": false,
    // });

    // make entire rows clickable
    $('#postsTable tbody').on('click', 'tr', function () {
        let href = $(this).find('a').prop('href');
        if(href) {
            window.location = href;
        }
    });
}